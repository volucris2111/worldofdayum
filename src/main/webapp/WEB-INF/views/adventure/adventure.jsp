<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="../resources/javascript/sockjs-0.3.4.min.js"></script>
<script src="../resources/javascript/stomp.min.js"></script>
<script type="text/javascript">
	var tileSize = 130;
	var tileDrawSize = 80;
	
	var terrainSheet = new Image();
	terrainSheet.src = "../resources/images/terrain.png";
	
	var avatarSheet = new Image();
	avatarSheet.src = "../resources/images/avatar.png";
	
	var buildingSheet = new Image();
	buildingSheet.src = "../resources/images/building.png";
	
	var map;
	var avatars;
	var canvas;
	var context;
	
	function connect() {
        var socket = new SockJS('/worldofdayum/worldofdayum');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            stompClient.subscribe('/user/adventure/updateavatars', function(avatars){
            	updateAvatars(JSON.parse(avatars.body));
            });
            stompClient.subscribe('/user/adventure/updatemap', function(map){
           		updateTiles(JSON.parse(map.body));
            });
        });
    }
	
	function updateAvatars(response)
	{
		avatars = response;
		drawMap();
	}
	
	function updateTiles(response)
	{
		map = response;
		drawMap();
	}
	
	function drawMap()
	{
		context.clearRect(0, 0, canvas.width, canvas.height);
		for(var c = 0; c < map.length; c++)
   		{
       		var mapTile = map[c];
       		var sheet;
       		if(mapTile.sheetName === "terrainSheet")
  			{
       			sheet = terrainSheet;
  			}
       		else if(mapTile.sheetName === "buildingSheet")
  			{
       			sheet = buildingSheet;
  			}
       		context.drawImage(sheet, mapTile.sheetPositionX, mapTile.sheetPositionY, tileSize, tileSize, mapTile.relativePositionX * tileDrawSize, mapTile.relativePositionY * tileDrawSize, tileDrawSize, tileDrawSize);
   		}
		for(var c = 0; c < avatars.length; c++)
   		{
       		var avatar = avatars[c];
       		context.drawImage(avatarSheet, 0, 0, tileSize, tileSize, avatar.relativePositionX * tileDrawSize, avatar.relativePositionY * tileDrawSize, tileDrawSize, tileDrawSize);
   		}
		updateActions();
	}
	
	$(function() {
		canvas = document.getElementById("myCanvas");
		context = canvas.getContext("2d");
	    connect();
	    initAvatars();
	    getMap();
	    $("#myCanvas").mousemove(function(event){
	    	var position = getRelativeMouseCoord(event);
	    	var xpos = position.x * tileDrawSize;
	    	var ypos = position.y * tileDrawSize; 
	    	drawMap();
	    	context.beginPath();
	    	context.moveTo(xpos, ypos);
	    	context.lineTo(xpos + tileDrawSize, ypos);
	    	context.lineTo(xpos + tileDrawSize, ypos + tileDrawSize);
	    	context.lineTo(xpos, ypos + tileDrawSize);
	    	context.lineTo(xpos, ypos);
	    	context.stroke();
		});
	    $("#myCanvas").click(function(event){
	    	stompClient.send("/app/move/mouse", {}, JSON.stringify(getRelativeMouseCoord(event)));
	    	getMap();
	    });
	    
        $( "#dialog" ).dialog({
          autoOpen: false,
          show: {
            effect: "fade",
            duration: 300
          },
          hide: {
            effect: "fade",
            duration: 300
          },
          position: { my: "center", at: "center", of: "#myCanvas" },
          closeOnEscape: true,
          modal: true
        });
	});
	
	function getRelativeMouseCoord(event)
	{
		var xpos = 0;
    	var ypos = 0;
    	if(event.offsetX==undefined)
    	  {
    	    xpos = event.pageX-$('#myCanvas').offset().left;
    	    ypos = event.pageY-$('#myCanvas').offset().top;
    	  }             
    	  else
    	  {
    	    xpos = event.offsetX;
    	    ypos = event.offsetY;
    	  }
    	xpos = parseInt(xpos / tileDrawSize);
    	ypos = parseInt(ypos / tileDrawSize);
    	var position = {x : xpos, y : ypos};
    	return position;
	}
	    
	function getMap()
	{
		 $.ajax({
		        url: '${pageContext.request.contextPath}/adventure/mapcluster',
		        type: "GET",
		        async: false,
		        success: function(data) {
		        	updateTiles(data);
		        	updateActions();
		        }
		    });
	}
	
	function initAvatars()
	{
		 $.ajax({
		        url: '${pageContext.request.contextPath}/adventure/avatars',
		        type: "GET",
		        async: false,
		        success: function(data) {
		        	avatars = data;
		        }
		    });
	}
	
	$(document).keyup(function(e)
	{
		e.stopPropagation();
		var key = e.keyCode ? e.keyCode : e.which;
		if(key == 38 || key == 40 || key == 37 || key == 39)
		{
			e.preventDefault();
			stompClient.send("/app/move/keyboard", {}, key);
			getMap();
		}
	});
	
	$(document).keydown(function(e)
	{
	    e.stopPropagation();
	    if (e.keyCode === 40) {
	        e.preventDefault();
	    } else if (e.keyCode === 38) {
	        e.preventDefault();

	    }
	});
	
	
	function updateActions()
	{
		$.ajax({
	        url: '${pageContext.request.contextPath}/adventure/currentfield',
	        type: "GET",
	        async: false,
	        success: function(data) {
	        	$("#actions").html(data);
	        	 $(function() {
	        		    $( "#accordion" ).accordion({
	        		    	activate: function( event, ui ) {
	        		    		$(ui.oldHeader.children()[1]).html("+")
	        		    		$(ui.newHeader.children()[1]).html("-")
	        		    	}
	        		    });
       			  });
	        	 $(function() {
	        		    $( "#menu" ).menu();
	        		  });
	        }
	    });
	}
	
	function showAvatar(avatarId)
	{
		$.ajax({
	        url: '${pageContext.request.contextPath}/adventure/avatars/' + avatarId + '/',
	        type: "GET",
	        async: false,
	        success: function(data) {
	        	$( "#dialog" ).html(data);
	        	$( "#dialog" ).dialog( "open" );
	        }
		});
	}
	
	function showBuilding(buildingId)
	{
		$.ajax({
	        url: '${pageContext.request.contextPath}/building/' + buildingId + '/modal',
	        type: "GET",
	        async: false,
	        success: function(data) {
	        	$( "#dialog" ).html(data);
	        	$( "#dialog" ).dialog( "open" );
	        }
		});
	}
	
	function build()
	{
		$.ajax({
	        url: '${pageContext.request.contextPath}/adventure/build',
	        type: "GET",
	        async: false,
	        success: function(data) {
	        	$( "#dialog" ).html(data);
	        	$( "#dialog" ).dialog( "open" );
	        }
		});
	}
</script>
<table>
	<tr>
		<td colspan="2"><canvas id="myCanvas" width="560" height="560"></canvas></td>
		<td valign="top" id="actions">
		</td>
	</tr>
</table>

<div id="dialog">
</div>
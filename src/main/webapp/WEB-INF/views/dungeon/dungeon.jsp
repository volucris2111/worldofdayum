<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<script src="../resources/javascript/sockjs-0.3.4.min.js"></script>
    <script src="../resources/javascript/stomp.min.js"></script>
    <script src="../resources/javascript/jquery-2.1.1.min.js"></script>
	<script type="text/javascript">
		var tileSize = 130;
		var tileDrawSize = 80;
		var terrainSheet = new Image();
		terrainSheet.src = "../resources/images/terrain.png";
		var raiderSheet = new Image();
		raiderSheet.src = "../resources/images/raider.png";
		var map;
		var canvas;
		var context;
		function connect() {
	        var socket = new SockJS('/dungeonlordsandraiders/dungeonlordsandraiders');
	        stompClient = Stomp.over(socket);
	        stompClient.connect({}, function(frame) {
	            stompClient.subscribe('/user/dungeon/updatedungeon', function(map){
	            	updateGameMap(JSON.parse(map.body));
	            });
	        });
	    }
		
		function updateGameMap(response)
		{
			map = response;
			drawMap();
		}
		
		function drawMap()
		{
			context.clearRect(0, 0, canvas.width, canvas.height);
			for(var c = 0; c<map.length; c++)
    		{
        		var field = map[c];
        		context.drawImage(terrainSheet, field.fieldTypeId * tileSize, 0, tileSize, tileSize, field.relativePositionX * tileDrawSize, field.relativePositionY * tileDrawSize, tileDrawSize, tileDrawSize);
        		if(field.raiderIds != null)
        		{
        			if(field.raiderIds.length > 0)
	        		{
	        			context.drawImage(raiderSheet, 0, 0, tileSize, tileSize, field.relativePositionX * tileDrawSize, field.relativePositionY * tileDrawSize, tileDrawSize, tileDrawSize);
	        		}
        		}
    		}
		}
		
		$(function() {
			canvas = document.getElementById("myCanvas");
			context = canvas.getContext("2d");
		    connect();
		    initMap();
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
		    	var clickTest = getRelativeMouseCoord(event);
		    	stompClient.send("/app/move/mouse", {}, JSON.stringify(clickTest));
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
		    
		function initMap()
		{
			 $.ajax({
			        url: '<c:url value="/dungeon/plaindungeon"/>',
			        type: "GET",
			        success: function(data) {
			        	updateGameMap(data);
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
	</script>
<table>
	<tr>
		<td>
			<div id="testDiv"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2"><canvas id="myCanvas" width="560" height="560"></canvas></td>
	</tr>
</table>
</body>
</html>
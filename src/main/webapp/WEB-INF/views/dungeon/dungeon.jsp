<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<script src="../resources/javascript/sockjs-0.3.4.min.js"></script>
    <script src="../resources/javascript/stomp.min.js"></script>
    <script src="../resources/javascript/jquery-2.1.1.min.js"></script>
	<script type="text/javascript">
		var tileSize = 130;
		var terrainSheet = new Image();
		terrainSheet.src = "../resources/images/terrain.png";
		var raiderSheet = new Image();
		raiderSheet.src = "../resources/images/raider.png";
		
		
		var canvas;
		var context;
		function connect() {
	        var socket = new SockJS('/dungeonlordsandraiders/dungeonlordsandraiders');
	        stompClient = Stomp.over(socket);
	        stompClient.connect({}, function(frame) {
	            stompClient.subscribe('/dungeon/updatedungeon', function(map){
	            	updateGameMap(JSON.parse(map.body));
	            });
	        });
	    }
		
		function updateGameMap(response)
		{
			for(var c = 0; c<response.length; c++)
    		{
        		var field = response[c];
        		context.drawImage(terrainSheet, field.fieldTypeId * tileSize, 0, tileSize, tileSize, field.positionX * 80, field.positionY * 80, 80, 80);
        		if(field.raiderIds != null)
        		{
        			if(field.raiderIds.length > 0)
	        		{
	        			context.drawImage(raiderSheet, 0, 0, tileSize, tileSize, field.positionX * 80, field.positionY * 80, 80, 80);
	        		}
        		}
    		}
		}
		
		$(function() {
			canvas = document.getElementById("myCanvas");
			context = canvas.getContext("2d");
		    connect();
		    initMap();
		});
		
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
		$(window).keyup(function(e)
		{
			e.stopPropagation();
			var key = e.keyCode ? e.keyCode : e.which;
			if(key == 38 || key == 40 || key == 37 || key == 39)
			{
				e.preventDefault();
				stompClient.send("/app/move", {}, key);
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
		<td colspan="2"><canvas id="myCanvas" width="880" height="880"	></canvas></td>
	</tr>
</table>
</body>
</html>
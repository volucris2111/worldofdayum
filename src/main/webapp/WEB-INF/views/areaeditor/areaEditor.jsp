<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
    <script src="../resources/javascript/jquery-2.1.1.min.js"></script>
	<script type="text/javascript">
		var tileSize = 130;
		var tileDrawSize = 80;
		var size = 5;
		var terrainSheet = new Image();
		terrainSheet.src = "../resources/images/terrain.png";
		var map;
		var canvas;
		var context;
		
		function updateFields(response)
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
        		context.drawImage(terrainSheet, field.sheetPositionX, field.sheetPositionY, tileSize, tileSize, field.relativePositionX * tileDrawSize, field.relativePositionY * tileDrawSize, tileDrawSize, tileDrawSize);
    		}
			context.beginPath();
	    	context.moveTo(size * tileDrawSize, size * tileDrawSize);
	    	context.lineTo(size * tileDrawSize + tileDrawSize, size * tileDrawSize);
	    	context.lineTo(size * tileDrawSize + tileDrawSize, size * tileDrawSize + tileDrawSize);
	    	context.lineTo(size * tileDrawSize, size * tileDrawSize + tileDrawSize);
	    	context.lineTo(size * tileDrawSize, size * tileDrawSize);
	    	context.stroke();
		}
		
		$(function() {
			canvas = document.getElementById("myCanvas");
			context = canvas.getContext("2d");
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
		    	var mousePosition = getRelativeMouseCoord(event);
		    	$("#positionX").val(parseInt($("#positionX").val()) + mousePosition.x - size);
		    	$("#positionY").val(parseInt($("#positionY").val()) + mousePosition.y - size);
		    	getMap();
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
			size = parseInt($("#size").val());
			$("#myCanvas").attr("width", ((2 * size) + 1) * tileDrawSize);
			$("#myCanvas").attr("height", ((2 * size) + 1) * tileDrawSize);
			var urlPath = '<c:url value="/admin/areaeditor"/>';
			 $.ajax({
			        url: urlPath + "/?x=" + $("#positionX").val() + "&y=" + $("#positionY").val() + "&areaId=" + $("#areaId").val() + "&size=" + $("#size").val(),
			        type: "GET",
			        success: function(data) {
			        	updateFields(data);
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
				if(key == 38)
				{
					$("#positionY").val(parseInt($("#positionY").val()) - 1);
				}
				if(key == 40)
				{
					$("#positionY").val(parseInt($("#positionY").val()) + 1);
				}
				if(key == 37)
				{
					$("#positionX").val(parseInt($("#positionX").val()) - 1);
				}
				if(key == 39)
				{
					$("#positionX").val(parseInt($("#positionX").val()) + 1);
				}
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
		
		function setFieldType(fieldTypeId)
		{
			var urlPath = '<c:url value="/admin/areaeditor"/>';
			$.ajax({
		        url: urlPath + "/?x=" + $("#positionX").val() + "&y=" + $("#positionY").val() + "&areaId=" + $("#areaId").val() + "&fieldTypeId=" + fieldTypeId,
		        type: "GET",
		        success: function() {
		        	getMap();
		        }
		    });
		}
	</script>
<table>
	<tr>
		<td>
			PositionX
		</td>
		<td>
			<input type="number" id="positionX" value="0">
		</td>
		<td>
			PositionY
		</td>
		<td>
			<input type="number" id="positionY" value="0">
		</td>
		<td>
			AreaId
		</td>
		<td>
			<input type="number" id="areaId" value="0">
		</td>
		<td>
			Size
		</td>
		<td>
			<input type="number" id="size" value="5">
		</td>
		<td>
			<button type="button" onclick="getMap()">Update</button>
		</td>
	</tr>
	<tr>
		<td colspan="9"><canvas id="myCanvas" width="880" height="880"></canvas></td>
	</tr>
	<tr>
</table>
<div>
	<table>
		<tr>
			<c:forEach items="${fieldTypes}" var="fieldType">
				<td>
					<button onclick="setFieldType('${fieldType.id}')" type="button" style="background-image: url(../resources/images/terrain.png); background-position: -${fieldType.sheetPositionX}px -${fieldType.sheetPositionY}px; height: 130px; width: 130px;">
					</button>
				</td>
			</c:forEach>
		</tr>
	</table>
</div>
</body>
</html>
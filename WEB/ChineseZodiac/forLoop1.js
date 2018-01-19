function makeTable(array1, array2) {
	var table = document.getElementById("123");
	var row = table.insertRow(0);
	for (var i = 0; i < array1.length; i++) {
		row.insertCell(i).innerHTML = array1[i] + "<br /><img src=\"images/" + array2[i] + "\">";
	}
	setYears();
}

function setYears(){
	var day = new Date();
	var year = day.getFullYear();
	var yearList = [];

	for (var i = 1912; i <= year; i++){
		yearList.push(i);
	}

	var table = document.getElementById("123");
	var count =1;
	
	for (var i = 0; i < yearList.length; i++) {
		var row = table.insertRow(count);
		for (var j = 0; j < 12 && yearList.length != 0; j++) {
			row.insertCell(j).innerHTML = yearList[0];
			yearList.shift();
		}
		count++;
	}
}

function makeTable2(array1){
	var table = document.getElementById("123");
	var row = table.insertRow(0);
	for (var i = 0; i < array1.length; i++) {
		row.insertCell(i).innerHTML = array1[i][0] + "<br /><img src=\"images/" + array1[i][1] + "\">";
	}
	setYears();
}



// 	for (var i = 1912; i < year; i++) {
// 		if(i == 1912 || i%12 != 4) {
// 			table.insertRow(count).insertCell(0).innerHTML = i;
// 		} else {
// 			count++;
// 		}
// 		if (init < 12) {
// 			init++;
// 		} else {
// 			init = 0;
// 		}
// 	}
// }

// function year() {
// 	var d = new Date();
// 	var year = d.getFullYear();
// 	var list = new Array();

// 	for (var i = 1912; i <= year; i++) {
// 		list.push(i);
// 	}

// 	document.writeln("<tr>");
// 	for (var i = 0; i < list.length; i++) {
// 		for (var j = 0; j< 12 && list.length != 0; j++){
// 			document.writeln("<td>" + list[0] + "</td>");
// 			list.shift();
// 		}
// 		document.writeln("</tr><tr>");
// 	}
// 	document.writeln("</table>");



	// cell1.innerHTML = "new cell1";
	// cell2.innerHTML = "new cell2";


// 	document.writeln("<table border=\'1\'>" );
// 	document.writeln("<tr>");
// 	for (var i = 0; i < array1.length; i++) {
// 		document.writeln("<th class=\"imageTitle\">" + array1[i] + "<br /><img src=\"images/" + array2[i] + "\"></th>");
// 	}
// 	document.writeln("</tr>");
// 	year();
// }

// function year() {
// 	var d = new Date();
// 	var year = d.getFullYear();
// 	var list = new Array();

// 	for (var i = 1912; i <= year; i++) {
// 		list.push(i);
// 	}

// 	document.writeln("<tr>");
// 	for (var i = 0; i < list.length; i++) {
// 		for (var j = 0; j< 12 && list.length != 0; j++){
// 			document.writeln("<td>" + list[0] + "</td>");
// 			list.shift();
// 		}
// 		document.writeln("</tr><tr>");
// 	}
// 	document.writeln("</table>");

// }


// 	var d = new Day();
// 	var year = d.getFullYear();
// 	var list = new Array();

// 	for (var i = 1912; i < year; i++) {
// 		yearOrder.push(i);
// 	}

// 	document.writeln("<tr>");
// 	for (var i = 0; i < yearOrder; i++) {
// 		for (var j = 0; j< 12; j++){
// 			document.writeln("<td>" + yearOrder[0] "</td>");
// 			yearOrder.shift();
// 		}
// 		document.writeln("</tr><tr>");
// 	}
// }
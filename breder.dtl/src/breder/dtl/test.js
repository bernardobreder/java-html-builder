while (document.body.childNodes.length > 0) {
    document.body.removeChild(document.body.childNodes[0]);
}
var gtable = document.createElement("table");
gtable.setAttribute("width", "100%");
gtable.setAttribute("cellpadding", "0px");
gtable.setAttribute("cellspacing", "0px");
var gtr = document.createElement("tr");
var gtd = document.createElement("td");
gtd.setAttribute("width", "100%");
document.body.appendChild(gtable);
{
    var table = document.createElement("table");
    table.setAttribute("width", "98px");
    table.setAttribute("colpadding", "0px");
    table.setAttribute("cellspacing", "0px");
    var tr = document.createElement("tr");
    var td = document.createElement("td");
    td.setAttribute("width", "100%");
    var input = document.createElement("textarea");
    input.style.border = "1px solid";
    input.style.width = "98px";
    input.style.height = "98px";
    input.style.resize = "none";
    input.style.marginBottom = "-6px";
    input.style.setProperty("-webkit-marquee-increment", "0px");
    table.appendChild(tr);
    tr.appendChild(td);
    td.appendChild(input);
    gtable.appendChild(table);
}
{
    var table = document.createElement("table");
    table.setAttribute("width", "98px");
    table.setAttribute("colpadding", "0px");
    table.setAttribute("cellspacing", "0px");
    var tr = document.createElement("tr");
    var td = document.createElement("td");
    td.setAttribute("width", "100%");
    var input = document.createElement("input");
    input.style.border = "1px solid";
    input.style.width = "98px";
    input.style.height = "98px";
    table.appendChild(tr);
    tr.appendChild(td);
    td.appendChild(input);
    document.body.appendChild(table);
}

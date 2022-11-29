var canvas = document.getElementById("example");
var context = canvas.getContext("2d");
var image = new Image();
var imgpoint = new Image();
imgpoint.src = "img/cursor.png";
image.src = "img/cr.svg";
``
image.onload = function() {
    context.drawImage(image, 0, 0);
    loadCircles();
};

function sendPoint(x,y){
    let coor =
        { coor_x: x.toFixed(3),
            coor_y: y.toFixed(3),
            value_R: 1
        }
    $.get('controller', coor, function(data){
        window.location.reload();
    })
}

function saveCircle(x, y) {
    let circle = {
        "x": x,
        "y": y,
    };
    let circles = JSON.parse(localStorage.getItem("circles"));

    if (circles == null)
        circles = [];

    circles.push(circle);

    localStorage.setItem("circles", JSON.stringify(circles));
}

function loadCircles() {
    circlesStorage = localStorage.getItem("circles");

    circles = JSON.parse(circlesStorage);

    if (circles == null)
        return;

    for (let circle of circles) {
        drawCircle(context, circle.x, circle.y);
    }
}

function drawCircle(context, x, y){
    context.drawImage(imgpoint, x, y);
    context.beginPath();
    context.fill();
    context.closePath();
    context.stroke();
}

function windowToCanvas(canvas, x, y) {
    var bcanv = canvas.getBoundingClientRect();
    return { x: x - bcanv.left,
        y: y - bcanv.top
    };
}
canvas.addEventListener('click', function (e) {
    var x = e.clientX;
    var y = e.clientY;
    var loc = windowToCanvas(canvas, x, y);
    context.clearRect(0, 0, canvas.width, canvas.height);
    saveCircle(loc.x-10, loc.y-10);
    sendPoint((loc.x-175)/112, -(loc.y-175)/112);
});

loadCircles();
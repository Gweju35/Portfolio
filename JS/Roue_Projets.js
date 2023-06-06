var logo = document.getElementById('logo');
var textLogo = document.querySelector('.text_logo');

logo.addEventListener('mouseover', function () {
    textLogo.classList.add('hover');
});

logo.addEventListener('mouseout', function () {
    textLogo.classList.remove('hover');
});

/*------------------------------------------------------*/

const circles = document.querySelectorAll(".cercle");
const rectangles = document.querySelectorAll(".rectangle");

let areRectanglesVisible = false;

circles.forEach((circle, index) => {
    let rectangle = rectangles[index];

    circle.addEventListener("mouseover", () => {
        circle.style.backgroundColor = "black";
        if (!areRectanglesVisible) {
            rectangle.style.display = "block";
        }
    });

    circle.addEventListener("mouseout", () => {
        circle.style.backgroundColor = "";
        if (!areRectanglesVisible) {
            rectangle.style.display = "none";
        }
    });
});



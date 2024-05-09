var menuBurger = document.querySelector(".header-burger");
var menu = document.querySelector(".header-wrapper .menu");
var overlay = document.querySelector(".overlay");

/* Si la classe active est déjà présente, on l'enlève, sinon on lui donne */
document.querySelectorAll(".header-burger, .menu-item").forEach(function(element) {
    element.addEventListener("click", function() {
        menuBurger.classList.toggle("active");
        menu.classList.toggle("active");
    });
});

document.querySelectorAll(".header-burger").forEach(function(element) {
    element.addEventListener("click", function() {
        overlay.classList.toggle("active");
    });
});
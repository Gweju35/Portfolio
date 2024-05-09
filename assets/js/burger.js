var menuBurger = document.querySelector(".header-burger");
var menu = document.querySelector(".header-wrapper .menu");
var overlay = document.querySelector(".overlay");

/* Si la classe active est déjà présente, on l'enlève, sinon on lui donne */
document.querySelectorAll(".header-burger").forEach(function(element) {
    element.addEventListener("click", function() {
        menuBurger.classList.toggle("active");
        menu.classList.toggle("active");
        overlay.classList.toggle("active");
    });
});

document.querySelectorAll(".menu-item").forEach(function(element) {
    element.addEventListener("click", function() {
        menuBurger.classList.remove("active");
        menu.classList.remove("active");
        overlay.classList.remove("active");
    });
});
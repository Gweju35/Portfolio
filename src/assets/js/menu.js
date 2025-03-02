export function toggleMenuBurger() {
    const menuBurger = document.querySelector(".js-burger");
    const menu = document.querySelector(".js-menu");
    // const overlay = document.querySelector(".overlay");

    document.querySelectorAll(".js-burger").forEach(function(element) {
        element.addEventListener("click", function() {
            menuBurger.classList.toggle("active");
            menu.classList.toggle("active");
            // overlay.classList.toggle("active");
        });
    });

    document.querySelectorAll(".menu-item").forEach(function(element) {
        element.addEventListener("click", function() {
            menuBurger.classList.remove("active");
            menu.classList.remove("active");
            // overlay.classList.remove("active");
        });
    });
}
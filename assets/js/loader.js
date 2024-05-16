document.addEventListener("DOMContentLoaded", function() {
    var preloader = document.querySelector(".preloader");
    var loader = document.querySelector(".loader");
    var loading = document.querySelector(".loading");

    setTimeout(function() {
        loader.style.transition = "opacity 1s";
        loading.style.transition = "opacity 1s";
        loader.style.opacity = "0";
        loading.style.opacity = "0";
    }, 500); // le loader disparaît après 0.5s

    setTimeout(function() {
        preloader.style.transition = "opacity 1.5s";
        preloader.style.opacity = "0";
    }, 1000); // réduction de l'opacité du preloader après 1s
    setTimeout(function() {
        preloader.style.display = "none";
    }, 2500); // réduction du preloader après 2.5s
});

/* On attribue une classe loader aléatoirement */
document.addEventListener("DOMContentLoaded", function() {
    var loader = document.querySelector(".loader");
    var loaderClasses = ["loader-quart", "loader-double", "loader-circles", "loader-bars"];
    var randomIndex = Math.floor(Math.random() * loaderClasses.length);
    loader.classList.add(loaderClasses[randomIndex]);
});

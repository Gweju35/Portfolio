export function initHeader() {
    header = document.querySelector('.js-header');
    if (!header) return;

    menuBurger = document.querySelector('.js-burger');
    menu = document.querySelector('.js-menu');
    overlay = document.querySelector('.overlay');
    goTopLink = document.querySelector('.goTop');
    navbarLinks = document.querySelectorAll('.navbar-links');

    menuBurger?.addEventListener('click', toggleMenu);
    overlay?.addEventListener('click', closeMenu);
    goTopLink?.addEventListener('click', scrollToTop);
    navbarLinks.forEach(link => link.addEventListener('click', smoothScroll));
    window.addEventListener('scroll', handleScroll);
    window.addEventListener('resize', handleResize);

    handleScroll();
}

// variable globales
let isMenuOpen = false;
let header, menuBurger, menu, overlay, goTopLink, navbarLinks;

// Fonction qui ouvre/ferme le menu
function toggleMenu() {
    isMenuOpen = !isMenuOpen;

    menuBurger?.classList.toggle("active", isMenuOpen);
    menu?.classList.toggle("active", isMenuOpen);
    overlay?.classList.toggle("active", isMenuOpen);
    document.body.classList.toggle("no-scroll", isMenuOpen);
}

// Fonction qui ferme le menu
function closeMenu() {
    isMenuOpen = false;

    menuBurger?.classList.remove("active");
    menu?.classList.remove("active");
    overlay?.classList.remove("active");
    document.body.classList.remove("no-scroll");
}


// Fonction qui gère le scroll de la page
function handleScroll() {
    if (window.scrollY > 0) {
        header?.classList.add("active");
    } else {
        header?.classList.remove("active");
    }
}


// Fonction qui gère le resize de la fenêtre
function handleResize() {
    if (window.innerWidth >= 1024 && isMenuOpen) {
        closeMenu();
    }
}


// Fonction qui ferme le menu et effectue un scroll vers l'élément cible
function smoothScroll(e) {
    e.preventDefault();
    const targetId = e.target.getAttribute("href");
    const targetElement = document.querySelector(targetId);
    if (targetElement) {
        targetElement.scrollIntoView({ behavior: "smooth" });
    }
    closeMenu();
}


// Fonction qui gère le scroll vers le haut du site
function scrollToTop(e) {
    e.preventDefault();
    window.scrollTo({ top: 0, behavior: "smooth" });
}
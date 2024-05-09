window.addEventListener('scroll', function() {
    var header = document.querySelector('.header-section');
    var scrollPosition = window.scrollY;

    // Si un scroll est détecté on ajoute la classe active à la balise header
    if (scrollPosition > 0) {
        header.classList.add('active');
    } 
    // Si on remonte tout en haut de la page on retire la classe active
    else {
        header.classList.remove('active');
    }
});
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

// Permet de ne pas modifier l'URL lorsque l'on clique sur un lien de la navbar
document.addEventListener('DOMContentLoaded', function() {
    var links = document.querySelectorAll('.navbar-links');
    links.forEach(function(link) {
      link.addEventListener('click', function(e) {
        e.preventDefault(); 
        var targetId = this.getAttribute('href'); 
        var targetElement = document.querySelector(targetId); 
        if (targetElement) {
          targetElement.scrollIntoView({ behavior: 'smooth' });
        }
      });
    });
  });
function showContent(theme, event) {
    event.preventDefault();
    var links = document.getElementsByTagName('a');
    for (var i = 0; i < links.length; i++) {
        links[i].classList.remove('active-link');
    }

    // Masquer le contenu du thème précédent
    var activeContent = document.querySelector('.content.active');
    activeContent.classList.remove('active');
    activeContent.classList.remove('fade-in');
    activeContent.classList.add('fade-out');

    // Afficher le contenu du thème sélectionné avec un léger délai pour permettre la transition
    setTimeout(function() {
        var selectedContent = document.getElementById('content' + theme);
        selectedContent.classList.add('active');
        selectedContent.classList.remove('fade-out');
        selectedContent.classList.add('fade-in');

        // Activer le lien du thème sélectionné
        var selectedLink = document.getElementById('link' + theme);
        selectedLink.classList.add('active-link');
    }, 10);
}
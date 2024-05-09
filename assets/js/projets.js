document.addEventListener("DOMContentLoaded", function() {
    // Récupérer tous les éléments <li> dans la liste de projets
    var projetsItems = document.querySelectorAll(".projets-list li");

    // Récupérer tous les éléments .taf
    var tafElements = document.querySelectorAll(".taf");

    // Par défaut, afficher le premier élément .taf et ajouter la classe active
    tafElements[0].classList.add("active");
    projetsItems[0].classList.add("active_li");

    // Boucler sur chaque élément <li>
    projetsItems.forEach(function(item, index) {
        // Ajouter un écouteur d'événement au clic
        item.addEventListener("click", function() {
            // Masquer tous les éléments .taf
            tafElements.forEach(function(taf) {
                taf.classList.remove("active");
            });

            // Afficher seulement le .taf correspondant à l'index du clic
            tafElements[index].classList.add("active");

            // Retirer la classe active de tous les <li>
            projetsItems.forEach(function(li) {
                li.classList.remove("active_li");
            });

            // Ajouter la classe active uniquement au <li> cliqué
            item.classList.add("active_li");
        });
    });
});
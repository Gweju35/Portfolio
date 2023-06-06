/*----------------- Partie Logo -----------------*/
var logo = document.getElementById('logo');
var textLogo = document.querySelector('.text_logo');

logo.addEventListener('mouseover', function () {
    textLogo.classList.add('hover');
});

logo.addEventListener('mouseout', function () {
    textLogo.classList.remove('hover');
});



/*----------------- Partie Popup -----------------*/
var closeButtons = document.getElementsByClassName("close");
var modals = document.getElementsByClassName("modal");

for (var i = 0; i < closeButtons.length; i++) {
    closeButtons[i].addEventListener("click", function () {
        // Fermer la fenêtre modale correspondante
        var modal = this.closest(".modal");
        modal.style.display = "none";
    });
}
var triggers = document.getElementsByClassName("modal-trigger");
for (var i = 0; i < triggers.length; i++) {
    triggers[i].addEventListener("click", function () {
        var modalId = this.getAttribute("data-modal");
        var modal = document.getElementById(modalId);
        modal.style.display = "block";
    });
}
document.getElementById("popup-link").addEventListener("click", function (event) {
    event.preventDefault(); // Empêche le lien d'effectuer son comportement par défaut
    document.getElementById("overlay").style.display = "block";
});
document.getElementById("close-btn").addEventListener("click", function () {
    document.getElementById("overlay").style.display = "none";
});

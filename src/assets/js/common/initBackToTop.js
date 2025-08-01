// Fonction qui permet d'initialiser le bouton pour revenir en haut de la page
export function initBackToTop() {
    const button = document.querySelector('.js-back-to-top');
    if (!button) return;

    const toggleButtonVisibility = () => {
        const scrollPosition = window.scrollY;
        button.classList.toggle('active', scrollPosition > 100);
    };

    const scrollToTop = () => {
        window.scrollTo({
            top: 0,
            behavior: 'smooth'
        });
    };

    // Ajouter les écouteurs
    window.addEventListener('scroll', toggleButtonVisibility);
    button.addEventListener('click', scrollToTop);

    // Init au cas où on a déjà scrollé
    toggleButtonVisibility();
}
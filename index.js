const observer = new IntersectionObserver(entries => {
    entries.forEach(entry => {
        console.log(entry);
        if (entry.isIntersecting) {
            entry.target.classList.add('show');
        }
    });
});

// Animations des éléments cachés de la gauche vers la droite
const hiddenElementsLeft = document.querySelectorAll('.hidden_left');
hiddenElementsLeft.forEach((el) => observer.observe(el));

// Animations des éléments cachés de la droite vers la gauche
const hiddenElementsRight = document.querySelectorAll('.hidden_right');
hiddenElementsRight.forEach((el) => observer.observe(el));
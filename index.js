const observer = new IntersectionObserver(entries => {
    entries.forEach(entry => {
        console.log(entry);
        if (entry.isIntersecting) {
            entry.target.classList.add('show');
        }
    });
});

const hiddenElementsLeft = document.querySelectorAll('.hidden_left');
hiddenElementsLeft.forEach((el) => observer.observe(el));

const hiddenElementsRight = document.querySelectorAll('.hidden_right');
hiddenElementsRight.forEach((el) => observer.observe(el));
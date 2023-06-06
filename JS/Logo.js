var logo = document.getElementById('logo');
var textLogo = document.querySelector('.text_logo');

logo.addEventListener('mouseover', function () {
    textLogo.classList.add('hover');
});

logo.addEventListener('mouseout', function () {
    textLogo.classList.remove('hover');
});
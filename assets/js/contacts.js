const footerInfos = document.querySelectorAll('.footer-infos');

footerInfos.forEach(info => {
    const footerIcon = info.querySelector('.footer-icon'); /* Cercle des icônes des contacts */
    const icon = info.querySelector('.footer-icon i'); /* Icônes des contacts */
    const contactName = info.querySelector('.contact-name'); /* Le nom du contact */
    
    footerIcon.addEventListener('mouseover', () => {
        footerIcon.style.backgroundColor = '#08D565';
        footerIcon.style.border = '1px solid white';
        footerIcon.style.boxShadow = '0 0 0 1px #fff';
        icon.style.fontSize = '40px';
        contactName.style.color = '#08D565';
    });

    footerIcon.addEventListener('mouseout', () => {
        footerIcon.style.backgroundColor = '#2D2A4A';
        footerIcon.style.border = '1px solid rgba(255, 255, 255, 0.5)';
        footerIcon.style.boxShadow = 'none';
        icon.style.fontSize = '30px';
        contactName.style.color = '#fff';
    });

    contactName.addEventListener('mouseover', () => {
        footerIcon.style.backgroundColor = '#08D565';
        footerIcon.style.border = '1px solid white';
        footerIcon.style.boxShadow = '0 0 0 1px #fff';
        icon.style.fontSize = '40px';
        contactName.style.color = '#08D565';
    });

    contactName.addEventListener('mouseout', () => {
        footerIcon.style.backgroundColor = '#2D2A4A';
        footerIcon.style.border = '1px solid rgba(255, 255, 255, 0.5)';
        footerIcon.style.boxShadow = 'none';
        icon.style.fontSize = '30px';
        contactName.style.color = '#fff';
    });
});

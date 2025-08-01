export function initFooter() {
    const contactLinks = Array.from(document.querySelectorAll('.contact-links'));
    const downloadBtn = document.querySelector('.js-download-cv');

    contactLinks.forEach(link => {
        link.addEventListener('click', smoothScroll);
    });

    downloadBtn?.addEventListener('click', downloadFile);
}


function smoothScroll(event) {
    event.preventDefault();
    const targetId = event.target.getAttribute('href');
    const targetElement = document.querySelector(targetId);
    if (targetElement) {
        targetElement.scrollIntoView({ behavior: 'smooth' });
    }
}

function downloadFile(event) {
    event.preventDefault();
    const fileUrl = '/Portfolio/files/PERRIGUEY_Julien_CV.pdf';
    const link = document.createElement('a');
    link.href = fileUrl;
    link.download = 'PERRIGUEY_Julien_CV.pdf';
    link.click();
    link.remove();
}
import { gsap } from "gsap";

export function initAccordionSkills() {
    const accordions = document.querySelectorAll('.js-skills-accordion');
    accordions.forEach((accordion) => {
        const toggle = accordion.querySelector('.js-toggle-skills');
        const content = accordion.querySelector('.js-content-skills');
        const icon = accordion.querySelector('.js-plus-skills');

        if (!toggle || !content || !icon) return;

        toggle.addEventListener('click', () => {
            const isHidden = content.classList.contains('hidden');

            if (isHidden) {
                content.classList.remove('hidden');
                gsap.fromTo(
                    content,
                    { height: 0, opacity: 0 },
                    {
                        height: content.scrollHeight,
                        opacity: 1,
                        duration: 0.7,
                        ease: "power2.out",
                        onComplete: () => content.style.height = 'auto'
                    }
                );
            } else {
                gsap.to(content, {
                    height: 0,
                    opacity: 0,
                    duration: 0.7,
                    ease: "power2.inOut",
                    onComplete: () => content.classList.add('hidden')
                });
            }

            icon.classList.toggle('rotate-45');
        });
    });
}


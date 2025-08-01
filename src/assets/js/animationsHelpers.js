import {gsap} from "gsap";
import {ScrollTrigger} from "gsap/ScrollTrigger.js";
import {SplitText} from "gsap/SplitText.js";
import {CSSRulePlugin} from "gsap/CSSRulePlugin.js";
import {DrawSVGPlugin} from "gsap/DrawSVGPlugin.js";

gsap.registerPlugin(ScrollTrigger);
gsap.registerPlugin(SplitText);
gsap.registerPlugin(CSSRulePlugin);
gsap.registerPlugin(DrawSVGPlugin);


export function animateTitle(pageTitle, distance, stagger, duration, type) {
    if (pageTitle) {
        pageTitle.split = new SplitText(pageTitle, {
            type: "lines, words, chars",
            linesClass: "split-line"
        });

        let targetElements;

        switch (type) {
            case "words":
                targetElements = pageTitle.split.words;
                break;
            case "chars":
                targetElements = pageTitle.split.chars;
                break;
            case "lines":
                targetElements = pageTitle.split.lines;
                break;
            default:
                targetElements = pageTitle;
                break;
        }

        return gsap.from(targetElements, {
            duration: duration,
            ease: "power4.inOut",
            y: distance,
            autoAlpha: 0,
            stagger: stagger,
        });
    } else {
        console.error("animateTitle - cannot find element to animate !")
    }
}

export function animateSlideVertical(element, distance, stagger, duration, ease) {
    if (element) {
        return gsap.from(element, {
            duration: duration,
            ease: ease ? ease : "expo.inOut",
            y: distance,
            autoAlpha: 0,
            stagger: stagger,
        });
    } else {
        console.error("animateSlideVertical - cannot find element to animate !")
    }
}

export function animateSlideHorizontal(element, distance, stagger, duration, ease) {
    if (element) {
        return gsap.from(element, {
            duration: duration,
            ease: ease ? ease : "expo.inOut",
            x: distance,
            autoAlpha: 0,
            stagger: stagger,
        });
    } else {
        console.error("animateSlideVertical - cannot find element to animate !")
    }
}
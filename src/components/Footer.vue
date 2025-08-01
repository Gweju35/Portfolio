<template>
  <footer id="contact" class="pt-24">
    <div class="py-16 bg-pf-deep-blue1 text-white">
      <div class="flex flex-col justify-center items-center gap-0 container md:gap-16 lg:items-start lg:grid lg:gap-8 lg:grid-cols-3">
        <!-- Logo & CV -->
        <div class="flex flex-col lg:block lg:mx-auto w-full">
          <div class="flex items-center mb-6 text-2xl font-semibold text-gray-900 md:mb-0">
            <a href="#">
              <img src="~@/assets/images/logo.svg" class="h-28 w-28" alt="Portfolio Logo" loading="lazy">
            </a>
          </div>
          <a class="flex cursor-pointer w-fit gap-x-2 mb-6 md:my-4 max-w-72 sm:max-w-none lg:max-w-72 text-sm sm:text-base py-2 px-4 font-semibold text-white uppercase border-2 border-pf-green bg-pf-green rounded font-sans transition-all duration-300 ease-in-out no-underline md:hover:bg-transparent md:hover:text-pf-green">
            <p><i class="fa-solid fa-download"></i></p>
            <p>Télécharger mon CV</p>
          </a>
        </div>
        <!-- Liens de contact -->
        <div class="mt-12 flex flex-col md:mt-0 lg:block lg:mx-auto w-full ">
          <h2 class="mb-6 font-josefin font-bold text-xl text-pf-green md:mb-4 lg:mb-10">Contactez-moi</h2>
          <ul class="flex flex-col ">
            <li class="mb-4 text-lg text-bold lg:text-start">
              <div class="max-w-96 sm:max-w-none lg:max-w-96">
                <a href="mailto:julienprgy@gmail.com" class="group flex items-center w-fit gap-x-3 text-base text-white md:hover:text-pf-green font-medium transition-colors duration-300 ease-in-out">
                  <i class="fa-solid fa-envelope"></i>
                  <p>julienprgy@gmail.com</p>
                </a>
              </div>
            </li>
            <li class="mb-4 text-lg text-bold lg:text-start">
              <div class="max-w-96 sm:max-w-none lg:max-w-96">
                <a href="tel:06-06-45-59-92" class="flex items-center gap-x-3 w-fit text-base text-white md:hover:text-pf-green font-medium transition-colors duration-300 ease-in-out">
                  <i class="fa-solid fa-phone"></i>
                  <p>06 06 45 59 92</p>
                </a>
              </div>
            </li>
            <li class="mb-4 text-lg text-bold lg:text-start">
              <div class="max-w-96 sm:max-w-none lg:max-w-96">
                <a href="https://www.linkedin.com/in/julien-perriguey-b24540261/" target="_blank" class="flex items-center gap-x-3 w-fit text-base text-white md:hover:text-pf-green font-medium transition-colors duration-300 ease-in-out">
                  <i class="fa-brands fa-linkedin"></i>
                  <p>LinkedIn</p>
                </a>
              </div>
            </li>
            <li class="mb-4 text-lg text-bold lg:text-start">
              <div class="max-w-96 sm:max-w-none lg:max-w-96">
                <a href="https://github.com/Gweju35" target="_blank" class="flex items-center gap-x-3 w-fit text-base text-white md:hover:text-pf-green font-medium transition-colors duration-300 ease-in-out">
                  <i class="fa-brands fa-github"></i>
                  <p>Github</p>
                </a>
              </div>
            </li>
          </ul>
        </div>
        <!-- Navigation du site -->
        <div class="mt-12 flex flex-col md:mt-0 lg:block lg:mx-auto w-full">
          <h2 class="mb-6 font-josefin font-bold text-xl text-pf-green md:mb-4 lg:mb-10">Navigation</h2>
          <ul class="font-normal text-white text-lg gap-y-3 gap-x-10 p-0 flex flex-col md:flex-row md:gap-x-8 lg:flex-col lg:grid xl:grid-cols-2 xl:gap-x-0">
            <li><a href="#diplomes" class="contact-links transition-all duration-300 ease-in-out md:hover:text-pf-green font-medium">Diplômes</a></li>
            <li><a href="#experiences" class="contact-links transition-all duration-300 ease-in-out md:hover:text-pf-green font-medium">Expériences</a></li>
            <li><a href="#projets" class="contact-links transition-all duration-300 ease-in-out md:hover:text-pf-green font-medium">Projets</a></li>
            <li><a href="#competences" class="contact-links transition-all duration-300 ease-in-out md:hover:text-pf-green font-medium">Compétences</a></li>
            <li><a href="#contacts" class="contact-links transition-all duration-300 ease-in-out md:hover:text-pf-green font-medium">Contact</a></li>

          </ul>
        </div>
      </div>
    </div>
    <!-- Copyright -->
    <div class="container flex items-center justify-start bg-pf-darkblue">
      <span class="py-5 text-pf-green text-sm font-bold sm:text-base text-center">© 2025 Julien Perriguey, Tous droits réservés.</span>
    </div>
  </footer>
</template>

<script>
import { onMounted } from 'vue';
import { initFooter } from "@/assets/js/common/initFooter";

export default {
  name: 'AppFooter',
  setup() {
    onMounted(() => {
      initFooter();
    });
  }
};
</script>

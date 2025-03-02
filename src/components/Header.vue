<template>
  <div class="overlay"></div>

<!--  sticky ??-->
  <header class="js-header fixed block w-full left-0 top-4 z-40 transition-all ease-linear duration-300 border-transparent" :class="{ active: isHeaderActive }">
    <div class="w-full container">
      <div class="flex items-center justify-between flex-wrap py-4 px-0">
        <div class="w-auto">
          <a href="#" @click="closeMenu" class="goTop flex flex-row items-center">
            <img src="../assets/images/logo.svg" alt="logo" class="w-10 h-12 sm:w-12 sm:h-14 max-w-full mr-2.5">
            <h1 class="text-pf-green text-xl sm:text-2xl uppercase font-bold">Perriguey</h1>
          </a>
        </div>
        <ul class="js-menu menu lg:flex lg:items-center lg:flex-wrap lg:m-0 lg:p-0 lg:!ml-auto border border-transparent">
          <li class="menu-item p-0 list-none" @click="closeMenu"><a href="#diplomes" class="navbar-links py-1.5 px-4 font-semibold font-josefin text-white uppercase transition-all ease-in-out duration-300 hover:text-pf-green">Diplômes</a></li>
          <li class="menu-item p-0 list-none" @click="closeMenu"><a href="#experiences" class="navbar-links py-1.5 px-4 font-semibold font-josefin text-white uppercase transition-all ease-in-out duration-300 hover:text-pf-green">Expériences</a></li>
          <li class="menu-item p-0 list-none" @click="closeMenu"><a href="#projets" class="navbar-links py-1.5 px-4 font-semibold font-josefin text-white uppercase transition-all ease-in-out duration-300 hover:text-pf-green">Projets</a></li>
          <li class="menu-item p-0 list-none" @click="closeMenu"><a href="#competences" class="navbar-links py-1.5 px-4 font-semibold font-josefin text-white uppercase transition-all ease-in-out duration-300 hover:text-pf-green">Compétences</a></li>
          <li class="menu-item p-0 list-none" @click="closeMenu"><a href="#contact" class="navbar-links py-1.5 px-4 font-semibold font-josefin text-white uppercase transition-all ease-in-out duration-300 hover:text-pf-green">Contact</a></li>
        </ul>
        <div class="js-burger burger lg:hidden relative cursor-pointer w-6 h-5" @click="toggleMenu">
          <span class="absolute inline-block h-[3px] w-full transition-all duration-300 ease-linear bg-white left-0 top-0"></span>
          <span class="absolute inline-block h-[3px] w-full transition-all duration-300 ease-linear bg-white left-0 top-1/2 -translate-y-2/4"></span>
          <span class="absolute inline-block h-[3px] w-full transition-all duration-300 ease-linear bg-white left-0 bottom-0"></span>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: 'AppHeader',
  data() {
    return {
      isHeaderActive: false,
      isMenuOpen: false,
    };
  },
  mounted() {
    // Gérer l'événement de scroll
    window.addEventListener('scroll', this.handleScroll);

    // Gérer le redimensionnement de la fenêtre
    window.addEventListener('resize', this.handleResize);

    // Empêcher le changement d'URL sur les liens de la navbar
    this.$nextTick(() => {
      const links = document.querySelectorAll('.navbar-links');
      links.forEach(link => {
        link.addEventListener('click', this.smoothScroll);
      });

      // Gérer le bouton "Go to top"
      const goTopLink = document.querySelector('.goTop');
      if (goTopLink) {
        goTopLink.addEventListener('click', this.scrollToTop);
      }
    });
  },
  beforeUnmount() {
    // Nettoyer les événements
    window.removeEventListener('scroll', this.handleScroll);
    window.removeEventListener('resize', this.handleResize);

    const links = document.querySelectorAll('.navbar-links');
    links.forEach(link => {
      link.removeEventListener('click', this.smoothScroll);
    });
    const goTopLink = document.querySelector('.goTop');
    if (goTopLink) {
      goTopLink.removeEventListener('click', this.scrollToTop);
    }
  },
  methods: {
    toggleMenu() {
      const menuBurger = document.querySelector(".js-burger");
      const menu = document.querySelector(".js-menu");
      const overlay = document.querySelector(".overlay");

      this.isMenuOpen = !this.isMenuOpen;

      menuBurger.classList.toggle("active", this.isMenuOpen);
      menu.classList.toggle("active", this.isMenuOpen);
      overlay.classList.toggle("active", this.isMenuOpen);

      // Désactiver ou réactiver le scroll
      document.body.classList.toggle("no-scroll", this.isMenuOpen);
    },
    closeMenu() {
      const menuBurger = document.querySelector(".js-burger");
      const menu = document.querySelector(".js-menu");
      const overlay = document.querySelector(".overlay");

      this.isMenuOpen = false;

      menuBurger.classList.remove("active");
      menu.classList.remove("active");
      overlay.classList.remove("active");

      // Réactiver le scroll
      document.body.classList.remove("no-scroll");
    },
    handleScroll() {
      const scrollPosition = window.scrollY;
      this.isHeaderActive = scrollPosition > 0;
    },
    handleResize() {
      const windowWidth = window.innerWidth;
      if (windowWidth >= 1024 && this.isMenuOpen) {
        this.closeMenu();
      }
    },
    smoothScroll(e) {
      e.preventDefault();
      const targetId = e.target.getAttribute('href');
      const targetElement = document.querySelector(targetId);
      if (targetElement) {
        targetElement.scrollIntoView({ behavior: 'smooth' });
      }
    },
    scrollToTop(e) {
      e.preventDefault();
      window.scrollTo({ top: 0, behavior: 'smooth' });
    }
  }
}
</script>
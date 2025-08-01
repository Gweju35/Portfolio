<template>
  <div class="overlay"></div>

  <header class="js-header fixed block w-full left-0 top-4 z-40 transition-all ease-linear duration-300 border-transparent">
    <div class="w-full container">
      <div class="flex items-center justify-between flex-wrap py-4 px-0">
        <div class="w-auto">
          <a href="#" class="goTop flex flex-row items-center">
            <img src="../assets/images/logo.svg" alt="logo" class="w-10 h-12 sm:w-12 sm:h-14 max-w-full mr-2.5">
            <h1 class="text-pf-green text-xl sm:text-2xl uppercase font-bold">Perriguey</h1>
          </a>
        </div>
        <ul class="js-menu menu lg:flex lg:items-center lg:flex-wrap lg:m-0 lg:p-0 lg:!ml-auto border border-transparent">
          <li class="menu-item p-0 list-none"><a href="#diplomes" class="navbar-links py-1.5 px-4 font-semibold font-josefin text-white uppercase transition-all ease-in-out duration-300 hover:text-pf-green">Diplômes</a></li>
          <li class="menu-item p-0 list-none"><a href="#experiences" class="navbar-links py-1.5 px-4 font-semibold font-josefin text-white uppercase transition-all ease-in-out duration-300 hover:text-pf-green">Expériences</a></li>
          <li class="menu-item p-0 list-none"><a href="#projets" class="navbar-links py-1.5 px-4 font-semibold font-josefin text-white uppercase transition-all ease-in-out duration-300 hover:text-pf-green">Projets</a></li>
          <li class="menu-item p-0 list-none"><a href="#competences" class="navbar-links py-1.5 px-4 font-semibold font-josefin text-white uppercase transition-all ease-in-out duration-300 hover:text-pf-green">Compétences</a></li>
          <li class="menu-item p-0 list-none"><a href="#contact" class="navbar-links py-1.5 px-4 font-semibold font-josefin text-white uppercase transition-all ease-in-out duration-300 hover:text-pf-green">Contact</a></li>
        </ul>
        <div class="js-burger burger lg:hidden relative cursor-pointer w-6 h-5">
          <span class="absolute inline-block h-[3px] w-full transition-all duration-300 ease-linear bg-white left-0 top-0"></span>
          <span class="absolute inline-block h-[3px] w-full transition-all duration-300 ease-linear bg-white left-0 top-1/2 -translate-y-2/4"></span>
          <span class="absolute inline-block h-[3px] w-full transition-all duration-300 ease-linear bg-white left-0 bottom-0"></span>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
import { onMounted } from 'vue';
import { initHeader} from "@/assets/js/common/initHeader";

export default {
  name: 'AppHeader',
  setup() {
    onMounted(() => {
      initHeader();
    });
  }
};
</script>
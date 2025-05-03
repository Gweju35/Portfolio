<template>
  <section class="homeHeader pt-32 pb-24 sm:pt-40 md:pb-24 lg:pt-48 lg:pb-32 relative overflow-hidden bg-cover bg-center bg-no-repeat">
    <div class="homeShape shape-1"></div>
    <div class="homeShape shape-2"></div>
    <div class="homeShape shape-3"></div>
    <div class="homeShape shape-4"></div>
    <div class="homeShape shape-5"></div>
    <div class="homeShape shape-6"></div>

    <div class="container flex flex-col items-center justify-center gap-y-24 sm:gap-y-32 md:gap-y-40">
        <div class="w-full flex flex-col items-center justify-center lg:grid lg:grid-cols-2 lg:justify-items-center">
          <!--Titre-->
          <div class="relative lg:max-w-lg xl:max-w-xl mb-12">
            <h1 class="uppercase text-5xl md:text-7xl md:leading-[80px] xl:text-8xl xl:leading-[96px] font-bold m-0 text-white font-josefin mb-4 md:mb-6 xl:mb-8">
              <span class="text-pf-green block">Je suis</span>Julien Perriguey
            </h1>
            <h2 class="font-josefin italic text-pf-green font-semibold text-3xl md:text-4xl xl:text-5xl mb-4 md:mb-6 xl:mb-8">Alternant Développeur front-end</h2>
          </div>
          <!--Image-->
            <div class="relative">
              <img src="~@/assets/images/photo.png" class="z-10 bg-cover relative" alt="Photo">
              <div class="absolute w-full h-full border-[3px] border-pf-green z-10 border-l-0 border-t-0 left-0 top-0 xl:left-5 xl:top-5"></div>
              <div class="absolute w-full h-full border-[3px] border-pf-green z-10 border-r-0 border-b-0 right-0 top-0 xl:right-5 xl:-top-5"></div>
            </div>
        </div>
      </div>
  </section>
</template>

<script>
export default {
  name: 'PageHeader',
  methods: {
    smoothScroll(event) {
      event.preventDefault(); // Empêche le comportement par défaut du lien
      const targetId = event.target.getAttribute('href'); // Récupère l'ancre (#projets)
      const targetElement = document.querySelector(targetId); // Trouve l'élément correspondant

      if (targetElement) {
        targetElement.scrollIntoView({ behavior: 'smooth' }); // Fait défiler jusqu'à l'élément
      }
    },
  },
};
</script>
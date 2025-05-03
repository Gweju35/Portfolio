<template>
  <div class="flex flex-wrap bg-[#272440] mb-7">

    <div class="bg-pf-deep-blue1 w-full lg:w-80 p-7 flex flex-wrap justify-center items-center">
      <img :src="`${logoUrl}`" alt="Logo de la société" class="size-32 align-middle bg-gray-100 rounded-full">
    </div>

    <div class="jobDescription p-4 sm:p-6 md:p-8 lg:w-[calc(100%-320px)]">
      <h4 class="mb-5 capitalize font-bold text-white font-josefin text-xl sm:text-2xl">{{ title }}</h4>
      <div class="jobDescription text-sm leading-6 sm:text-base sm:leading-7" v-html="text"></div>
    </div>
  </div>
</template>

<script>
import CobaltLogo from '@/assets/images/companies/logo_cobalt.png';
import HeyliotLogo from '@/assets/images/companies/logo_heyliot.png';
import SbvLogo from '@/assets/images/companies/logo_sbv.png';
import FoirfouilleLogo from '@/assets/images/companies/logo_foirfouille.png';
import AllioraLogo from '@/assets/images/companies/logo_alliora.png';
import VilledefougeresLogo from '@/assets/images/companies/logo_villeDeFougeres.png';

export default {
  name: 'AppExperiences',
  props: {
    title: {
      type: String,
      required: true
    },
    text: {
      type: String,
      required: true
    },
    img: {
      type: String,
      required: true
    }
  },
  computed: {
    // Vérifie la valeur de `title` pour déterminer quelle icône utiliser
    logoUrl() {
      switch (this.img.toLowerCase()) {
        case 'cobalt':
          return CobaltLogo;
        case 'heyliot':
          return HeyliotLogo;
        case 'sbv':
          return SbvLogo;
        case 'foirfouille':
          return FoirfouilleLogo;
        case 'alliora':
          return AllioraLogo;
        case 'villedefougeres':
          return VilledefougeresLogo;
        default:
          return null;
      }
    },
  },
}
</script>
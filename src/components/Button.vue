<template>
  <button class="js-cta-button cta-button">
    <span>{{ title }}</span>
  </button>

</template>

<script>
export default {
  name: 'AppButton',
  props: {
    title: {
      type: String,
      required: true
    }
  }
}
</script>
<template>
  <div class="titleSection">
    <h2 class="title">
      <span class="shape"><span>{{ title }}</span></span>
    </h2>
  </div>
</template>

<script>
export default {
  name: 'TitleComponent',
  props: {
    title: {
      type: String,
      required: true
    }
  }
}
</script>
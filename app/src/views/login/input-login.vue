<template>
  <div class="hello">
    hueuhehuhue
  </div>
</template>

<script>
  import http from '@/store/http'

  export default {
    name: 'input-login',
    
    data () {
      return {
        msg: 'Welcome to Your Vue.js PWA'
      }
    },

    methods: {
    },

    mounted() {
      console.log('has been redirected to login')
      this.login()
    }
  };
</script>

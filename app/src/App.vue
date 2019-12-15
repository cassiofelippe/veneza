<template>
  <div id="app">
    <b-navbar toggleable="lg" ref="header-menu" class="fixed-top">
      <b-navbar-brand href="/">
        <img class="logo" alt="Veneza Logo" src="./assets/logo-white.png">
      </b-navbar-brand>
      <b-navbar-toggle class="bars" target="nav-collapse"><font-awesome-icon icon="bars" class="bars" /></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item @click="index('cliente')" title="Listar clientes">
            <font-awesome-icon icon="user-edit"/><span>&nbsp;Cliente</span>
          </b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
    <router-view />
  </div>
</template>

<script>
  export default {
    name: 'app',

    data() {
      return {};
    },

    methods: {
      index(route) {
        this.$router.push(route || '/').catch(e => e).then(() => {
          this.$router.go();
        });
        // window.location.hash = `#/${route}`;
      }
    }
  };

  export function formatCpf(value) {
    return value ? value.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g,'$1.$2.$3-$4') : value;
  }
</script>

<style>
  body {
    font-size: 1rem !important;
    font-weight: 400 !important;
    line-height: 1.5 !important;
    color: #2e2e2e !important;
    text-align: left !important;
    background-size: cover;
  }

  .body-view {
    padding: 65px 0px 20px 0px;
    background-color: white;
    -webkit-box-shadow: 0px 0px 9px 8px #580D1E;
    -moz-box-shadow: 0px 0px 9px 8px #580D1E;
    box-shadow: 0px 0px 9px 8px #580D1E;
  }

  label {
    font-weight: bold;
  }

  .navbar  {
    background-color: #791129;
    box-shadow: 0 0.25rem 0.25rem #580D1E, inset 0 -1px 5px #580D1E;
  }

  .nav-link {
    color: white !important;
  }

  .nav-link:hover {
    color: lightgrey !important;
  }

  .navbar-toggler-icon {
    background-color: transparent !important;
  }

  .logo {
    width: 100px;
    height: 100%;
  }
</style>

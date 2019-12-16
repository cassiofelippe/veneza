<template>
  <div id="app">
    <b-navbar toggleable="lg" ref="header-menu" class="fixed-top">
      <b-navbar-brand href="/">
        <img class="logo" alt="Veneza Logo" src="./assets/logo-white.png">
      </b-navbar-brand>
      <b-navbar-toggle class="bars" target="nav-collapse"><font-awesome-icon icon="bars" class="bars" /></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item @click="index('/cliente')" title="Listar clientes">
            <font-awesome-icon icon="user-edit"/><span>&nbsp;Cliente</span>
          </b-nav-item>
          <b-nav-item @click="index('/pedido')" title="Listar pedidos">
            <font-awesome-icon icon="file-alt"/><span>&nbsp;Pedido</span>
          </b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
    <b-col cols="12" style="height: 100px">&nbsp;</b-col>
      <router-view />
    </b-col>
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
      }
    }
  }

  export function formatCpf(value) {
    return value ? value.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g,'$1.$2.$3-$4') : value;
  }

  export function formatDate(date) {
    if (!date || typeof date !== 'string') {
      return date;
    } else {
      let onlyDate = date.split('T')[0].split('-'), onlyTime = date.split('T')[1].split('.')[0];
      return `${onlyDate[2]}/${onlyDate[1]}/${onlyDate[0]} ${onlyTime.split(':')[0]}:${onlyTime.split(':')[1]}`;
    }
  }
  
  export function formatFone(fone) {
    const insert = function (main_string, ins_string, pos) {
      if(typeof(pos) == 'undefined') {
        pos = 0;
      }

      if(typeof(ins_string) == 'undefined') {
        ins_string = '';
      }
   
      return main_string.slice(0, pos) + ins_string + main_string.slice(pos);
    };

    if (!fone || typeof fone !== 'string') {
      return fone;
    } else {
      fone = insert(fone, '(', 0);
      fone = insert(fone, ') ', 3);
      fone = insert(fone, '-', fone.length - 4);
      return fone;
    }
  }

  export function formatMoney(value) {
    return value ?  'R$ '+(value/1).toFixed(2).replace('.', ',').replace(/\B(?=(\d{3})+(?!\d))/g, '.') : value;
  }
</script>

<style>
  body {
    font-size: 1rem !important;
    font-weight: 400 !important;
    line-height: 1.5 !important;
    color: #2e2e2e !important;
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

  .page-title-controls {
    margin-left: auto;
  }

  button.btn-success {
    color: black;
    background-color: white;
    border-color: black;
  }

  button.btn-success:focus {
    color: black !important;
    background-color: white !important;
    border-color: black !important;
    box-shadow: 0 0 0 0.2rem rgba(0, 0, 0, 0.25) !important;
  }

  button.btn-success:hover {
    color: black !important;
    background-color: lightgrey !important;
    border-color: black !important;
  }

  .custom-control-input:checked ~ .custom-control-label::before {
    background-color: #791129 !important;
    border-color: #791129 !important;
  }

  .custom-control-label:hover {
    cursor: pointer;
  }

  .custom-control-input:focus:not(:checked) ~ .custom-control-label::before {
    border-color: #759492 !important;
  }

  .custom-control-input:focus ~ .custom-control-label::before {
    box-shadow: 0 0.25rem 0.25rem #791129, inset 0 -1px 5px #791129;
  }
  
  .custom-control-input:disabled:checked ~ label::before {
    border-color: #6C757D !important;
    background-color: #6C757D !important;
  }
</style>

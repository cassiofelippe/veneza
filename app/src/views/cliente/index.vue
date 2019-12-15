<template>
  <div>
    <b-container>
      <b-col class="page-title-holder d-flex align-items-center">
        <h3 class="page-title">Clientes</h3>
        <div class="page-title-controls">
          <b-button id="cliente-new" @click="_new" variant="success" size="sm" squared title="Novo cliente">
            <font-awesome-icon icon="plus"/> Novo
          </b-button>
        </div>
      </b-col>
    </b-container>

    <div>&nbsp;</div>
    
    <b-container>
      <b-col>
        <b-table
          head-variant="light"
          light small striped hover
          :fields="fields"
          :items="model"
          @row-clicked="rowClicked"
          @row-middle-clicked="rowMiddleClicked"
          @row-contextmenu="rowContextMenu"
          v-bind:style="{cursor: 'pointer'}">
          <template v-slot:cell(identificacao.cpf)="data">
            {{App.formatCpf(data.item.identificacao ? data.item.identificacao.cpf : '')}}
          </template>
        </b-table>
      </b-col>
      <div>&nbsp;</div>
    </b-container>

    <div id="right-click-menu">
      <ul>
        <li @click="rowMiddleClicked(data)"><font-awesome-icon icon="share-square" />&nbsp;Abrir em nova aba</li>
      </ul>
    </div>
  </div>
</template>

<script>
  import * as App from '@/App'
  import http from '@/store/http'

  export default {
    name: 'clientes',

    data() {
      return {
        fields: [
          {
            key: 'cpf',
            label: 'CPF',
            sortable: false
          },
          {
            key: 'nome',
            label: 'Nome'
          }
        ],
        model: [],
        App: App
      }
    },

    computed: {
      rows() {
        return this.model.length
      }      
    },

    methods: {
      index(){
        http.get('clientes');
      },
      show(_id) {
        this.$router.push({name: `clientes-show`, params: { _id }})
      },
      _new(){
        this.$router.push({name: `clientes-new`})
      },
      rowClicked(data) {
        this.$router.push(`cliente/${data._id}/show`);
      },
      rowMiddleClicked(data) {
        window.open(`cliente/${data._id}/show`, '_blank');
      },
      rowContextMenu(data, i, e) {
        e.preventDefault();

        const menu = document.getElementById('right-click-menu');

        menu.style.display = 'block';
        menu.style.left = e.clientX+'px';
        menu.style.top = e.clientY+'px';
        this.data = data;

        document.onclick = function() {
          menu.style.display = 'none';
        }
      }
    },

    mounted() {
      console.log('been here to init index')
      this.index();
    },

    components: {}
  };
</script>

<style scoped>
  svg[data-icon='edit'].index-icon {
    color: grey;
  }

  svg[data-icon='sync'].index-icon {
    color: #337ab7;
  }

  svg[data-icon='minus-circle'].index-icon {
    color: red;
  }

  svg[data-icon='check'].index-icon {
    color: green;
  }

  .col-padding {
    padding-left: 1em !important;
    padding-right: 1em !important;
  }
</style>
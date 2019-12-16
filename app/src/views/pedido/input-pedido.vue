<template>
 <b-container fluid>
    <b-col cols="12" sm="12" md="12" lg="12">&nbsp;</b-col>

    <b-row>
      <b-col cols="12" sm="12" md="6" lg="3">
        <label>CPF</label>
        <the-mask id="pedido-cpf" :disabled=disabled pattern="\d*" v-model="model.cpf" :mask="'###.###.###-##'" placeholder="000.000.000-00" class="form-control" />
      </b-col>

      <b-col cols="12" sm="12" md="6" lg="3">
        <label>Tipo</label>
        <b-form-select id="pedido-tipo" :disabled="disabled" v-model="model.tipo" :options="['COMPRA', 'CONSERTO']" class="form-control" />
      </b-col>

      <b-col cols="12" sm="12" md="6" lg="3">
        <label>Valor</label>
        <money id="pedido-valor" :disabled="disabled" v-model="model.valor" class="form-control" />
      </b-col>

      <b-col cols="12" sm="12" md="6" lg="3">
        <label>Pago?</label>
        <b-form-checkbox id="pedido-pago" v-model="model.pago" check="true" switch :disabled="disabled" />
      </b-col>

      <b-col cols="12" sm="12" md="12" lg="12">&nbsp;</b-col>

      <b-col cols="12" class="text-right" v-if="disabled">
        <b-button id="pedido-edit" @click="edit" type="submit" size="sm" squared variant="success" title="Editar">
          <font-awesome-icon icon="save"/>&nbsp;Editar
        </b-button>
      </b-col>
      <b-col cols="12" class="text-right" v-else>
        <b-button id="pedido-save" @click="save" type="submit" size="sm" squared variant="success" title="Salvar">
          <font-awesome-icon icon="save"/>&nbsp;Salvar
        </b-button>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
  import * as App from '@/App'
  import http from '@/store/http'
  import { Money } from 'v-money'

  export default {
    name: 'input-pedido',

    data () {
      return {
        model: {},
        disabled: false,
        App: App,
        money: {decimal: ',', thousands: '.', prefix: 'R$ ', precision: 2, masked: false}
      }
    },

    methods: {
      save() {
        if (!this.model.cpf || !this.model.tipo || !this.model.valor) {
          alert('Deve preencher todos os campos!');
        } else {
          http.post('pedidos', this.model).then((response) => {
            this.model = response;
            this.$router.push({name: 'pedidos-show', params: {_id: this.model._id}}).catch(e => e).then(() => {
              this.$router.go();
            });
          });
        }
      },

      show(_id) {
        http.get(`/pedidos/${_id}`).then(response => {
          this.model = response;
        });
      },

      edit() {
        this.$router.push({name: 'pedidos-edit', params: {_id: this.$route.params._id}});
        this.disabled = false;
      }
    },

    mounted() {
      let _id = this.$route.params._id;
      if (_id) {
        this.show(_id)
      }
      
      this.disabled = this.$route.path.includes('/show');
    },

    components: {
      Money
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #35495E;
  }
</style>

import axios from 'axios'

const http = axios.create({})

export default {
  get(resource) {
    console.log('resource', resource)
    return http.get(`http://localhost:8080/${resource}`).then((response, resolve, reject) => {
      console.log('response', response)
      resolve(response.data)
    })
  }
}


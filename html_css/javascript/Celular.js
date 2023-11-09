class Celular {
    constructor() {
        this.numero = "(11) 90000-0000";
    }

    ligar() {
        console.log('ligando...');
    }
}


let objeto = new Celular;

console.log(objeto);
console.log(objeto.numero);
objeto.ligar();

const botao = document.getElementById("btnOK") 
const input = document.getElementById("nome") 


function clickBtn() {
    // if(input.value == '') {
    //     alert('Preencha o nome');
    //     input.style.borderColor = 'RED'
    // }
    // console.log(input.value);
    fetch('https://swapi.dev/api/people/1')
    .then((resp)=>{
        // console.log(resp.json());
        resp.json().then((rs)=> {
            console.log(rs);
            console.log("nome:", rs.name);
        });
        
    })
}


botao.addEventListener('click', clickBtn)

// botao.addEventListener('mouseover', ()=> {
//     console.log("Mouse over");
// })

let vetor = ['White', 'Red', 12, 10, true,
    function notice() {
        console.log("Função executada");
    }
 ];

vetor.forEach((value, index)=>{
    console.log(index, value);
})

vetor[5]();

let vet = [
    ()=>{
        console.log('Número PAR');
    },
    ()=>{
        console.log('Número IMPAR');
    }
]
let numero = 10;
vet[numero%2]();


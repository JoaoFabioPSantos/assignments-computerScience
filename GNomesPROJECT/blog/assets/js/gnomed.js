const area = document.getElementById('area');
const gnome = document.getElementById('gnome');
const dialogo = document.getElementById('dialogo');

const clickPhrases = [
  'Então, veio nos conhecer melhor ?',
  'Dizem que se você comer um cogumelo vermelho, você fica gigante.',
  'Gnomos adoram trabalhar! Mas a gente reclama mesmo assim.',
  'Cogumelos são a base da vida!',
  'Acho que tudo bem vir conversar, mas não incomoda tanto.',
  'Quer virar amigo nosso? Ofereça uma esmeralda.'
];

const dragPhrases = [
  'AAAAAAAAAAAAAAAAAAH ME SOLTA C***LHO',
  'Eu não to com medo, você que deveria ter.',
  'Me solta por favor, devagar?',
  'Só porquê eu sou baixinho',
  '..........................'
];

let pointerDown = false;
let dragStarted = false;
let clickTimer = null;
let startX = 0;
let startY = 0;

let ghost = null;

const HOLD_DELAY = 200;
const MOVE_THRESHOLD_TO_CHANGE = 8;

function speakRandom(){
  dialogo.textContent = rand(clickPhrases);
}

function speakDrag(){
  dialogo.textContent = rand(dragPhrases);
}

function rand(arr){
  return arr[Math.floor(Math.random()*arr.length)];
}

function centerGnome(){
  gnome.style.visibility = 'visible';
  gnome.style.left = '50%';
  gnome.style.top = '50%';
  gnome.style.transform = 'translate(-50%, -50%)';
}

function startDrag(x, y){
  dragStarted = true;
  gnome.style.visibility = 'hidden';
  createGhost(x, y);
  speakDrag();
}

function resetState(){
  pointerDown = false;
  dragStarted = false;
  clearTimeout(clickTimer);
  removeGhost();
  gnome.style.visibility = 'visible';
}

function createGhost(x,y){
  if(ghost) return;
  ghost = document.createElement('img');
  ghost.src = "../assets/images/gnomedPanick.gif";
  ghost.className = 'ghost-gnome';
  document.body.appendChild(ghost);
  moveGhost(x,y);
}

function moveGhost(x,y){
  if(!ghost) return;
  ghost.style.left = x + 'px';
  ghost.style.top = y + 'px';
}

function removeGhost(withFall=false){
  if(!ghost) return;

  if(withFall){
    ghost.classList.add('ghost-fall');
    ghost.addEventListener('animationend', () => { 
      ghost?.remove();
      ghost = null;
    }, {once:true});
  } else {
    ghost.remove();
    ghost = null;
  }
}

area.addEventListener('pointerdown', (e)=>{
  e.preventDefault();
  pointerDown = true;
  dragStarted = false;
  startX = e.clientX;
  startY = e.clientY;

  clickTimer = setTimeout(()=>{
    if(pointerDown){
      startDrag(e.clientX, e.clientY);
    }
  }, HOLD_DELAY);
});

window.addEventListener('pointermove', (e)=>{
  if(!pointerDown) return;

  const dx = e.clientX - startX;
  const dy = e.clientY - startY;

  //Depois de pesquisar como poderia diferenciar, um click de um "segurar" é fazendo com que o click seja só com o mouse PARADO. Muito doido
  if(!dragStarted && Math.hypot(dx, dy) > MOVE_THRESHOLD_TO_CHANGE){
    clearTimeout(clickTimer);
    startDrag(e.clientX, e.clientY);
  }

  if(dragStarted){
    moveGhost(e.clientX, e.clientY);
  }
});

window.addEventListener('pointerup', ()=>{
  clearTimeout(clickTimer);
  if(!pointerDown) return;

  if(dragStarted){
    removeGhost(true);
    setTimeout(centerGnome, 1100);
  } else {
    speakRandom();
  }

  pointerDown = false;
  dragStarted = false;
});

window.addEventListener('pointercancel', resetState);

centerGnome();

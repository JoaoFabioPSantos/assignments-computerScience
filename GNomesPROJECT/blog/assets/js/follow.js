const followers = [...document.querySelectorAll(".follower")];
let mouseX = 0
let mouseY = 0;

const minDist = 60;  

window.addEventListener("mousemove", e => {
  mouseX = e.clientX;
  mouseY = e.clientY;
});

followers.forEach(follower => {
  follower.x = Math.random() * window.innerWidth;
  follower.y = Math.random() * window.innerHeight;

  follower.speed = 0.03 + Math.random() * 0.09;
});

function animate() {

  //Deixei possível adicionar vários gnomos, entretanto deixei apenas 3 para não ficar uma bagunça.
  followers.forEach((follower, i) => {

    follower.x += (mouseX - follower.x) * follower.speed;
    follower.y += (mouseY - follower.y) * follower.speed;

    for (let j = 0; j < followers.length; j++) {
      if (i == j) continue;

      const otherFollower = followers[j];
      const distanceX = follower.x - otherFollower.x;
      const distanceY = follower.y - otherFollower.y;
      const dist = Math.hypot(distanceX, distanceY);

      //verificador que tenta fazer com que eles fiquem longes um do outro por um tempo
      if (dist < minDist && dist > 0) {
        const overlap = minDist - dist;
        const force = overlap * 0.12;

        follower.x += (distanceX / dist) * force;
        follower.y += (distanceY / dist) * force;
      }
    }

    //um switch direction simples
    const img = follower.querySelector("img");
    img.style.transform = mouseX < follower.x ? "scaleX(-1)" : "scaleX(1)";


    follower.style.left = follower.x + "px";
    follower.style.top = follower.y + "px";
  });

  //função específica do js para que seja solicitado a função animate antes da próxima pintura de tela, tipo que tem na Unity. Não ironicamente pesquisei se isso existia.
  //https://developer.mozilla.org/en-US/docs/Web/API/Window/requestAnimationFrame <- Aqui basicamente, tem a documentação.
  requestAnimationFrame(animate);
}

animate();
const resultadoElement = document.getElementById('resultado');

function exibirResultado(dados) {
  resultadoElement.value = JSON.stringify(dados, null, 2);
}

// --- FUNÇÕES DE GNOMOS ---

async function listarTodosGnomos() {
  try {
    const response = await fetch('/api/gnomes');
    const dados = await response.json();
    exibirResultado(dados);
  } catch (error) {
    exibirResultado({ erro: error.message });
  }
}

async function adicionarGnomo(event) {
  event.preventDefault();
  const name = document.getElementById('gnome_name').value;
  const atribute = document.getElementById('gnome_atribute').value;

  try {
    const response = await fetch('/api/gnomes', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ name, atribute })
    });
    const dados = await response.json();
    exibirResultado({ mensagem: 'Gnomo registrado!', gnomo: dados });
    event.target.reset();
  } catch (error) {
    exibirResultado({ erro: error.message });
  }
}

// --- FUNÇÕES DE FÓRMULAS ---

async function listarTodasFormulas() {
  try {
    const response = await fetch('/api/formulas');
    const dados = await response.json();
    exibirResultado(dados);
  } catch (error) {
    exibirResultado({ erro: error.message });
  }
}

async function adicionarFormula(event) {
  event.preventDefault();
  const gnome_id = document.getElementById('formula_gnome_id').value;
  const descricao = document.getElementById('formula_desc').value;
  const expressao = document.getElementById('formula_exp').value;

  try {
    const response = await fetch('/api/formulas', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ gnome_id: parseInt(gnome_id), descricao, expressao })
    });
    const dados = await response.json();
    exibirResultado({ mensagem: 'Fórmula gravada!', dados });
    event.target.reset();
  } catch (error) {
    exibirResultado({ erro: error.message });
  }
}

async function buscarFormulasPorGnomo() {
  const id = document.getElementById('buscaGnomeId').value;
  if (!id) return alert('Digite o ID do Gnomo');

  try {
    const response = await fetch(`/api/formulas/gnomo/${id}`);
    const dados = await response.json();
    exibirResultado(dados);
  } catch (error) {
    exibirResultado({ erro: error.message });
  }
}

async function deletarFormula() {
  const id = document.getElementById('deletarFormulaId').value;
  if (!id) return alert('Digite o ID da fórmula');

  try {
    const response = await fetch(`/api/formulas/${id}`, { method: 'DELETE' });
    const dados = await response.json();
    exibirResultado({ mensagem: 'Conhecimento apagado!', dados });
  } catch (error) {
    exibirResultado({ erro: error.message });
  }
}

// Carregar ao iniciar
window.addEventListener('load', () => {
  listarTodosGnomos();
});
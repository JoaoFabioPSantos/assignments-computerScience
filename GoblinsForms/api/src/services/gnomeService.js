const repo = require('../repositories/gnomesRepository');

// --- SERVIÇOS DE GNOMOS ---
exports.listar = (cb) => {
  repo.listar(cb);
};

exports.criar = (name, atribute, cb) => {
  repo.criar(name, atribute, cb);
};

// --- SERVIÇOS DE FÓRMULAS ---
exports.salvarFormula = (gnome_id, descricao, expressao, cb) => {
  if (!expressao || expressao.trim() === "") {
    return cb(new Error("A expressão matemática não pode estar vazia."));
  }
  repo.salvarFormula(gnome_id, descricao, expressao, cb);
};

exports.listarTodasComGnomos = (cb) => {
  repo.listarTodasComGnomos(cb);
};

exports.listarPorGnomo = (gnome_id, cb) => {
  repo.listarPorGnomo(gnome_id, cb);
};

exports.deletarFormula = (id, cb) => {
  repo.deletarFormula(id, cb);
};
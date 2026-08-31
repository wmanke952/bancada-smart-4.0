import { http } from "./http.js";

export function listarProdutos() {
  return http("/produtos");
}

export function criarProduto(produto) {
  return http("/produtos", {
    method: "POST",
    body: JSON.stringify(produto),
  });
}

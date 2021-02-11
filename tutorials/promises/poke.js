insertPokemons = (results) => {
  // Pegamos o nosso elemento pai
  const container = document.getElementById("pokemon-container");

  results.forEach((pokemon) => {
    const name = document.createElement("p");
    name.innerHTML = pokemon.name;

    fetch(pokemon.url)
      .then((response) => response.json())
      .then(({ sprites: { front_default } }) => {
        const img = document.createElement("img");
        img.src = front_default;
        
        container.appendChild(name)
        container.appendChild(img)
      })
  })
}

const getPokemons = () => {
  fetch("https://pokeapi.co/api/v2/pokemon/?limit=10")
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      insertPokemons(data.results)
    })
    .catch((error) => {
      console.error(error);
    })
}

getPokemons();


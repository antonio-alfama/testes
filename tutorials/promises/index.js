const getPecasDeFruta = () => {
  return new Promise((resolve, reject) => {
    console.log("a angariar fruta...")

    resolve(JSON.stringify({
      quantity: 20,
      types: {
        apples: 5,
        oranges: 10,
        bananas: 5
      }
    }))
  })
}

getPecasDeFruta()
  .then((result) => {
    return JSON.parse(result)
  })
  .then((resultObject) => {
    throw new Error("xau ai")
    console.log("A nossa fruta foi resolvida com: ", resultObject)
  })
  .catch((error) => {
    console.log("Ups, algo correu mal com o resultado de: ", error)
  })

// Estados de uma promise

// PENDING

// FULLFILLED - then

// REJECTED - catch
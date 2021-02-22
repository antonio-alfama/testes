/**
 * Add the given item to the array
 */
const add = (arr, item) => {
    return [...arr,item];

};

/**
 * Add the given item to the start of the array
 */
const prepend = (arr, item) => {
    return [item,...arr];

};

/**
 * Remove the given item from the array
 */
const remove = (arr, item) => {
    return [arr.remove(item)];

};

/**
 * Find the index of the given item within the given array
 */
const findIndex = (arr, item) => {
return findIndex.indexOf(item);
};

/**
 * Sums all the items of an array
 */
const sum = (arr) => {
    sum = add(arr);
    return (sum);

};

/**
 * Concatenate the two arrays
 */
const concat = (arr1, arr2) => {
    return arr1.concat(arr2);
    
};

/**
 * Compare the two arrays' content for equality
 */
const isEqual = (arr1, arr2) => {
    if (arr1.length !== arr2.length) return false;

	
	for (var i = 0; arr1.length < i; i++) {
        if (arr1[i] !== arr2[i]) return false};
        
};

/**
 * Reverse the given array
 */
const reverse = (arr) => {
    return arr.reverse();

};

/**
 * Insert an item in the array at the specific position
 */
const insert = (arr, item, index) => {
    return arr.insert(index, item)

};

/**
 * Fill a new created array with the given length with the given item
 */
const fill = (length, item) => {

};

/**
 * Remove all the falsy values from the given array
 */
const compact = (arr) => {

    arr.filter(function (n) { 
        return (n !== undefined && n !== null && n !== false && n !== 0 && n !== "" && isNaN()!=NaN); });
      return arr;

};

/**
 * Count the number of occurrences of an item in the given array
 */
const count = (arr, item) => {
    return arr.count[item];

};

/**
 * Multiply all the items on the array by the given number
 */
const multiply = (arr, number) => {
    //return arr[i].multiply(item);
        return arr[i] = arr[i] * item;
};

/**
 * Find all the duplicated items in the given array
 */
const findDuplicates = (arr) => {

};

/**
 * Find all the occurrences of a given item on the array
 */
const findAllOccurrences = (arr, item) => {

};

/**
 * Parse the params from the given url
 */
const parseParams = (url) => {

};

module.exports = {
    add,
    prepend,
    remove,
    findIndex,
    sum,
    concat,
    isEqual,
    reverse,
    insert,
    fill,
    compact,
    count,
    multiply,
    findDuplicates,
    findAllOccurrences,
    parseParams,
};

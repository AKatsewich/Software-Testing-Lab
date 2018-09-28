check = (a,b,c) => {
    if(typeof a != 'number'|| typeof b != 'number'|| typeof c != 'number') {
        return false;
    }
    if (a + b <= c || a + c <= b ||  
        b + c <= a) 
        return false; 
    else
        return true; 
}
module.exports.check = check;


if (check(-2,-3,-7)) {
    console.log('True')
} else {
    console.log('False')
}
// console.log(typeof 42.2,5,'a')
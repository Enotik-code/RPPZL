const homePhone = document.getElementById('homePhone');
const mobilePhone= document.getElementById('mobilePhone');
const passportNumber = document.getElementById('inputPassportNumber')
const identificationNumber = document.getElementById('inputIdefNum')

let maskOptionsHome = {
  mask: '+{375}(17)000-00-00',
  lazy: false
};
let maskOptionsMobile = {
  mask: '+{375}(00)000-00-00',
  lazy: false
};
let maskOptionsPassportNumber = {
  mask: '0000000',
  lazy: false
};
let maskOptionsPassportSerries = {
  mask: 'АА',
  lazy: false
};
let maskOptionsIdentificationNumber = {
  mask: '0000000A000AA0',
  lazy: false
}; //меняешь на нужные данные в mask: номер телефона, идентификационный номер и тд. 
//Не работало из-за параметра lazy: true, ставишь всегда false
let mask = IMask(homePhone, maskOptionsHome); //создает маску, здесь юзается сторонняя библиотека IMask
let mask2 = IMask(mobilePhone,maskOptionsMobile);
let mask3 = IMask(passportNumber,maskOptionsPassportNumber);
let mask4 = IMask(identificationNumber, maskOptionsIdentificationNumber);
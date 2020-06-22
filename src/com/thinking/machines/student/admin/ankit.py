import qrcode
import sys
name1=sys.argv[1]
name2=sys.argv[2]
rollnumber=sys.argv[3]
str=name1+' '+name2+' '+rollnumber
name=name1+' '+name2
img = qrcode.make(str)
img.save('C:/minor/Staysafe/QR/'+name+'.png')
#print(type(img))
#print(img.size)
# <class 'qrcode.image.pil.PilImage'>
# (290, 290)
#main(aaa,name,rollnumber)


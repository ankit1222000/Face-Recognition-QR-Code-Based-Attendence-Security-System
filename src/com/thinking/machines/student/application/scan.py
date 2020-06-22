import cv2
import numpy as np
import pyzbar.pyzbar as pyzbar
global abc


def main():
 cap=cv2.VideoCapture(0)
 #image=cv2.imread(path)
 string=webcam(cap)
 print(string)
 cap.release()
 cv2.destroyAllWindows()


def webcam(cap):
 while True:
  aaa=''
  _,frame=cap.read()
  decodeObjects=pyzbar.decode(frame)
  for obj in decodeObjects:
   aaa=obj.data
   points=obj.polygon
  
 
   if len(points) > 4: 
    hull = cv2.convexHull(np.array([point for point in points], dtype=np.float32))
    hull = list(map(tuple, np.squeeze(hull)))
   else: 
    hull = points;
  
  
   n = len(hull)     
   for j in range(0,n):
    cv2.line(frame, hull[j], hull[ (j+1) % n], (255,0,0), 3)

    


  



  
  cv2.imshow("Scan Your QR Code Here",frame)
  key=cv2.waitKey(1)
  if(key==27):
   break
  if(len(aaa)>0 and aaa!=''):
   abc=str(aaa)
   #print(abc)
   return(abc)
   break


main()
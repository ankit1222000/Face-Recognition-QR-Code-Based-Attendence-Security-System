import cv2
import numpy as np
import pickle

labels={}
final={}
names=[]
face_cascade=cv2.CascadeClassifier('c:/minor/Staysafe/data/cascades/haarcascade_frontalface_alt2.xml')
eye_cascade=cv2.CascadeClassifier('c:/minor/Staysafe/data/cascades/haarcascade_eye.xml')
recognizer = cv2.face.LBPHFaceRecognizer_create()
recognizer.read('c:/minor/Staysafe/data/recognizer/face-trainner.yml')
with open("c:/minor/Staysafe/data/pickle/labels.pickle", 'rb') as f:
	final=pickle.load(f)
	labels={v:k for k,v in final.items()}
input_video=cv2.VideoCapture(0)
while (True):
 ret,frame=input_video.read()
 gray=cv2.cvtColor(frame,cv2.COLOR_BGR2GRAY)
 faces=face_cascade.detectMultiScale(gray,1.3,5)
 for(x,y,w,h) in faces:
  cv2.rectangle(frame,(x,y),(x+w,y+h),(255,0,0),2)
  roigray=gray[y:y+h,x:x+w]
  roicolor=frame[y:y+h,x:x+w]
  id_,conf=recognizer.predict(roigray)
  if conf>=45:
   
   
   name=labels[id_] 
   namer=" ".join(name.split("-"))
   names.append(namer)
   cv2.putText(frame,name,(x,y),cv2.FONT_HERSHEY_SIMPLEX,1,(255,255,0),2)
   eyes = eye_cascade.detectMultiScale(roigray, 1.1, 3) # We apply the detectMultiScale method to locate one or several eyes in the image.
   for (ex, ey, ew, eh) in eyes: # For each detected eye:
            cv2.rectangle(roicolor,(ex, ey),(ex+ew, ey+eh), (0, 255, 0), 2)
  
 cv2.imshow("Scan Yourself Here",frame)
 if(len(names)>60):
  student=max(set(names),key=names.count)
  print(student)
  break
 if cv2.waitKey(1) & 0xFF==ord('q'):
  break
input_video.release()
cv2.destroyAllWindows()
 
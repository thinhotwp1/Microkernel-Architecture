<h1> 🔗Microkernel (Plugin) Architecture </h1>

<h2>🔹1. Kiến trúc tổng thể Microkernel Architecture </h2>

Microkernel Architecture (Plugin Architecture) chia ứng dụng thành kernel (core) và các plugin (extension) có thể được nạp/dỡ động. Kernel cung cấp các chức năng cốt lõi, còn plugin triển khai các tính năng mở rộng.

🧩 Thành phần:

- Core / Kernel: Chứa các APIs, cấu trúc dữ liệu, dịch vụ nền tảng (authentication, logging,...).

- Plugin / Feature Modules: Cắm vào Core khi cần, mỗi module có thể xử lý nghiệp vụ riêng biệt.
  
🖼️ Mô hình tổng quát:

![image](https://github.com/user-attachments/assets/f8fbcfc2-19a3-437e-abf4-aafabdcc5895)

<h2>🔹2. Cấu trúc thư mục dự án Microkernel (Plugin) Architecture 📁</h2>

![microkernel-architecture-pom](https://github.com/user-attachments/assets/e7379433-91a1-45ef-b3af-c0b7b2bbacdf)


Trong đó:

-> Microkernel-Architecture là module cha chứa các module con: 

- plugin-api: Chứa interface cần implement
  
- plugin-impl-hello: Module triển khai interface của plugin-api
  
- app-core: Module load các plugins và execute chúng

- Thư mục plugins: app-core sẽ load các file .jar ở folder này và sử dụng (build từ các module plugins như plugin-impl-hello)
  
<h2>🔹3. Mã nguồn mẫu</h2>

```https://github.com/thinhotwp1/Microkernel-Architecture```

<h2>🔹4. Ưu điểm của Microkernel (Plugin) Architecture ✅</h2>

![image](https://github.com/user-attachments/assets/657b42f7-e6fc-41de-85ae-e868d538d37e)


<h2>🔹5. Một số dự án thực tế sử dụng Microkernel (Plugin) Architecture 🛠</h2>

![image](https://github.com/user-attachments/assets/ac567e3e-cff2-4490-aca7-dca15a1478c1)


<h2>🔹6. Khi nào nên dùng Microkernel (Plugin)🤔</h2>

![image](https://github.com/user-attachments/assets/67cc7896-fe92-4cd4-81e1-dddc6b810eb4)

